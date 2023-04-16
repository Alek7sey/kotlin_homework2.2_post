open class LinkAttachment(override val type: String = "link", link: Link) : Attachment {
}

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val previewPage: String,
    val previewUrl: String
)