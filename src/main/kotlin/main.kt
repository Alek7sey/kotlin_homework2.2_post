fun main() {

    val audio1 = Audio(
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
    val video1 = Video(
        4,
        6,
        "Matrix",
        " ",
        1998,
        2000
    )

    val post1 = Post(
        0,
        1,
        1,
        34,
        20130409,
        "",
        111,
        354,
        1,
        comments = Comments(count = 1),
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
    val post2 = Post(
        0,
        2,
        4,
        34,
        20130425,
        "",
        222,
        354,
        1,
        comments = Comments(count = 145),
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
    val post3 = Post(
        0,
        3,
        5,
        34,
        20130425,
        "",
        333,
        354,
        1,
        comments = Comments(count = 145),
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
    val update = Post(
        3,
        3,
        5,
        34,
        20130401,
        "",
        999,
        354,
        1,
        comments = Comments(count = 145),
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