object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var idPost = 1


    fun getId(): Int {
        return posts.last().id
    }

    fun addPost(post: Post): Post {
        if (posts.isEmpty()) {
            post.id = idPost
            idPost++
            posts += post
        } else {
            idPost = posts.last().id + 1
            post.id = idPost
            posts += post
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postes) in posts.withIndex()) {
            if (postes.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun printPosts() {
        posts.forEach { println(it) }
    }

    fun printComments() {
        comments.forEach { println(it) }
    }


    fun clear() {
        posts = emptyArray()
        idPost = 1
        comments = emptyArray()
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, postes) in posts.withIndex())
            if (postes.id == postId) {
                comments += comment
                return comment
            }
        throw PostNotFoundException("No post with id = $postId")

    }
}
