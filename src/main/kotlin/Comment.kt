data class Comment(
//    val count: Int,
//    val canPost: Boolean = false,
//    val groupCanPost: Boolean = false,
//    val canClose: Boolean = false,
//    val canOpen: Boolean = false
    var id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut?,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Attachment?,
    val parentStack: Array<Int>?,
    val thread: СommentThread?
)