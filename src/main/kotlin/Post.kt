data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val comments: Comments,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Int = 0,
    val isFavorite: Boolean = false
)