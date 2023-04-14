import org.junit.Test
import org.junit.Before
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService
        service.add(
            Post(
                0,
                1,
                1,
                34,
                20130409,
                "",
                111,
                354,
                1,
                comments = Comments(count = 1),
                null,
                null,
                null,
                1,
                "post",
                null,
                123,
                null,
                donut = null,
                postponedId = 456
            )
        )
        val result = service.getId()
        assertEquals(1, result)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
        val service = WallService
        service.add(
            Post(
                0,
                1,
                1,
                34,
                20130409,
                "",
                111,
                354,
                1,
                comments = Comments(count = 1),
                null,
                null,
                null,
                1,
                "post",
                null,
                123,
                null,
                donut = null,
                postponedId = 456
            )
        )
        service.add(
            Post(
                0,
                2,
                4,
                34,
                20130425,
                "",
                222,
                354,
                1,
                comments = Comments(count = 145),
                null,
                null,
                null,
                1,
                "copy",
                null,
                123,
                null,
                donut = null,
                postponedId = 456
            )
        )
        service.add(
            Post(
                0,
                3,
                5,
                34,
                20130425,
                "",
                333,
                354,
                1,
                comments = Comments(count = 145),
                null,
                null,
                null,
                1,
                "copy",
                null,
                123,
                null,
                donut = null,
                postponedId = 456
            )
        )
        val update = Post(
            3,
            3,
            5,
            34,
            20130401,
            "",
            999,
            354,
            1,
            comments = Comments(count = 145),
            null,
            null,
            null,
            1,
            "copy",
            null,
            123,
            null,
            donut = null,
            postponedId = 999
        )
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNonExistent() {
        val service = WallService
        service.add(
            Post(
                0,
                1,
                1,
                34,
                20130409,
                "",
                111,
                354,
                1,
                comments = Comments(count = 1),
                null,
                null,
                null,
                1,
                "post",
                null,
                123,
                null,
                donut = null,
                postponedId = 456
            )
        )
        service.add(
            Post(
                0,
                2,
                4,
                34,
                20130425,
                "",
                222,
                354,
                1,
                comments = Comments(count = 145),
                null,
                null,
                null,
                1,
                "copy",
                null,
                123,
                null,
                donut = null,
                postponedId = 456
            )
        )
        service.add(
            Post(
                0,
                3,
                5,
                34,
                20130425,
                "",
                333,
                354,
                1,
                comments = Comments(count = 145),
                null,
                null,
                null,
                1,
                "copy",
                null,
                123,
                null,
                donut = null,
                postponedId = 456
            )
        )
        val update = Post(
            5,
            3,
            5,
            34,
            20130401,
            "",
            999,
            354,
            1,
            comments = Comments(count = 145),
            null,
            null,
            null,
            1,
            "copy",
            null,
            123,
            null,
            donut = null,
            postponedId = 999
        )
        val result = service.update(update)
        assertFalse(result)
    }
}