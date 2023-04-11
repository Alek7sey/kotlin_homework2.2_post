object WallService {
    private var posts = emptyArray<Post>()
    private var id = 1

    fun getId(): Int {
        return posts.last().id
    }

    fun add(post: Post): Post {
        if (posts.isEmpty()) {
            post.id = id
            id++
            posts += post
        } else {
            id = posts.last().id + 1
            post.id = id
            posts += post
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postes) in posts.withIndex()) {
            if (postes.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun printPosts() {
        posts.forEach { println(it) }
    }

    fun clear() {
        posts = emptyArray()
        id = 1
    }
}