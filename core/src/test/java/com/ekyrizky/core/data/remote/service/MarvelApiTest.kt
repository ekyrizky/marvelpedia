package com.ekyrizky.core.data.remote.service

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ekyrizky.core.utils.MockResponses
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.*
import org.junit.Assert.assertEquals
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.math.roundToInt

class MarvelApiTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var service: MarvelApi
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MarvelApi::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `test request getHeroes success`() = runBlocking {
        enqueueResponse(MockResponses.Heroes.STATUS_200)
        val limit = 20
        val offset = 0
        service.getHeroes(offset, limit)

        val request = mockWebServer.takeRequest()
        assertEquals("GET", request.method)
        assertEquals("/characters?offset=$offset&limit=$limit", request.path)
    }

    @Test
    fun `test response GetHeroes status code 200`() = runBlocking {
        enqueueResponse(MockResponses.Heroes.STATUS_200)
        val limit = 20
        val offset = 0
        val response = service.getHeroes(offset, limit)
        
        assertCode(200, response.code)
        assertEquals("Ok", response.status)
        Assert.assertNull(response.message)

        val responseData = response.data
        assertEquals(offset, responseData.offset)
        assertEquals(limit, responseData.limit)
        assertEquals(limit, responseData.count)
        assertEquals(limit, responseData.results.size)
        MatcherAssert.assertThat(responseData.results, CoreMatchers.instanceOf(List::class.java))
    }

    @Test
    fun `test response GetHeroes status code 401`() = runBlocking {
        enqueueResponse(MockResponses.Heroes.STATUS_401)
        val response = service.getHeroes()

        assertEquals("InvalidCredentials", response.code)
        assertEquals("That hash, timestamp and key combination is invalid.", response.message)
        Assert.assertNull(response.status)
        Assert.assertNull(response.data)
    }

    @Test
    fun `test response GetHeroes status code 409`() = runBlocking {
        enqueueResponse(MockResponses.Heroes.STATUS_409)
        val limit = 101
        val offset = 0
        val response = service.getHeroes(offset, limit)

        assertCode(409, response.code)
        assertEquals("You may not request more than 100 items.", response.status)
        Assert.assertNull(response.message)
        Assert.assertNull(response.data)
    }

    private fun enqueueResponse(filePath: String) {
        val inputStream = javaClass.classLoader?.getResourceAsStream(filePath)
        val bufferSource = inputStream?.source()?.buffer()
        val mockResponse = MockResponse()

        mockWebServer.enqueue(mockResponse.setBody(bufferSource!!.readString(Charsets.UTF_8)))
    }

    private fun assertCode(number1: Number, number2: Any) {
        assertEquals(number1, (number2 as Double).roundToInt())
    }
}