import org.junit.Test
import org.junit.Before
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService
        service.add(Post(0, 1, 1, 20130409, "", comments = Comments(count = 1)))
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
        service.add(Post(0, 1, 1, 20130409, "", comments = Comments(count = 1)))
        service.add(Post(0, 2, 2, 20130410, "", comments = Comments(count = 0)))
        service.add(Post(0, 3, 3, 20990409, "", comments = Comments(count = 1)))
        val update = Post(3, 45, 45, 20230415, "", comments = Comments(count = 99))
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNonExistent() {
        val service = WallService
        service.add(Post(0, 1, 1, 20130409, "", comments = Comments(count = 1)))
        service.add(Post(0, 2, 2, 20130410, "", comments = Comments(count = 0)))
        service.add(Post(0, 3, 3, 20990409, "", comments = Comments(count = 1)))
        val update = Post(5, 45, 45, 20230415, "", comments = Comments(count = 99))
        val result = service.update(update)
        assertFalse(result)
    }
}