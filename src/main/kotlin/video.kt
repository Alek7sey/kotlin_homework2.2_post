open class VideoAttachment(override val type: String = "video", video: Video) : Attachment {
}

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val date: Int,
    val views: Int
)