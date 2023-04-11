
fun main() {
    val post1 = Post(0, 1, 1, 20130409, "", comments = Comments(count = 1))
    val post2 = Post(0, 2, 1, 20130410, "", comments = Comments(count = 2))
    val post3 = Post(0, 3, 3, 20990409, "", comments = Comments(count = 1))
    val update = Post(3, 3,3, 20991231, "update", comments = Comments(count = 3))

    val posts = WallService.add(post1)
    println(posts)
    println()
    WallService.add(post2)
    WallService.add(post3)
    WallService.printPosts()
    println()
    println(WallService.update(update))
    WallService.printPosts()

}