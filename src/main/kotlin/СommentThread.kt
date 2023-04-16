data class СommentThread(
    val count: Int,
    val items: Array<Comment>,
    val canPost: Boolean = false,
    val showReplyButton: Boolean = false,
    val groupsCanPost: Boolean = false
)