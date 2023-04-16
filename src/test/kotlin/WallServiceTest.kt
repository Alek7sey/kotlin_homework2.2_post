import org.junit.Test
import org.junit.Before
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WallServiceTest {
    private val audio1 = Audio(
        3,
        5,
        "B2",
        "Альбом",
        75,
        "",
        1,
        2,
        3,
        1999
    )
    private val video1 = Video(
        4,
        6,
        "Matrix",
        " ",
        1998,
        2000
    )
    private val comment = Comment(
        45,
        6,
        20130416,
        "comment test",
        null,
        23,
        32,
        null,
        null,
        null
    )

    private val post1 = Post(
        0,
        1,
        1,
        34,
        20130409,
        "",
        111,
        354,
        1,
        comments = null,
        null,
        null,
        null,
        1,
        "post",
        arrayOf(AudioAttachment(audio = audio1), VideoAttachment(video = video1)),
        null,
        123,
        null,
        donut = null,
        postponedId = 456
    )

    private val post2 = Post(
        2,
        1,
        1,
        34,
        20130415,
        "",
        111,
        3300,
        1,
        comments = null,
        null,
        null,
        null,
        1,
        "post",
        arrayOf(AudioAttachment(audio = audio1), VideoAttachment(video = video1)),
        null,
        123,
        null,
        donut = null,
        postponedId = 654
    )

    private val post3 = Post(
        0,
        2,
        4,
        34,
        20130425,
        "",
        222,
        354,
        1,
        comments = null,
        null,
        null,
        null,
        1,
        "copy",
        null,
        null,
        123,
        null,
        donut = null,
        postponedId = 456
    )

    private val update = Post(
        3,
        3,
        5,
        34,
        20130401,
        "",
        999,
        354,
        1,
        comments = null,
        null,
        null,
        null,
        1,
        "copy",
        null,
        null,
        123,
        null,
        donut = null,
        postponedId = 999
    )

    private val updateNo = Post(
        5,
        3,
        5,
        34,
        20130401,
        "",
        999,
        354,
        1,
        comments = null,
        null,
        null,
        null,
        1,
        "copy",
        null,
        null,
        123,
        null,
        donut = null,
        postponedId = 999
    )

    @Test
    fun addPost() {
        val service = WallService
        service.addPost(post1)
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
        service.addPost(post1)
        service.addPost(post2)
        service.addPost(post3)
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNonExistent() {
        val service = WallService
        service.addPost(post1)
        service.addPost(post2)
        service.addPost(post3)
        val result = service.update(updateNo)
        assertFalse(result)
    }

    @Test
    fun createComment() {
        val service = WallService
        service.addPost(post1)
        service.addPost(post2)
        service.addPost(post3)
        service.createComment(1, comment)
        val result = comment.id
        assertEquals(45, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService
        service.addPost(post1)
        service.addPost(post2)
        service.addPost(post3)
        service.createComment(5, comment)
    }

}