data class Comments(
    val count: Int,
    val canPost: Boolean = false,
    val groupCanPost: Boolean = false,
    val canClose: Boolean = false,
    val canOpen: Boolean = false
)