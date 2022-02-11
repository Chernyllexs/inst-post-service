# POST SERVICE
This service runs on port 9001 and is responsible for creating and views posts.

#### Function:
* добавить пост;
    * отправить фото в photo-service;
* получить все посты по userId;
* получить пост по postId;
* удалить все посты по userId;
* удалить пост по postId;
* проверка наличия поста;
* редактирование поста;
    * редактирование фото;

#### Endpoints:
* POST /post/create (add a post);
* GET /post/get-all-posts-for-user/{userId};
* GET /post/get-post-by-id/{postId};
* GET /post/check-post/{postId};
* DELETE /post/delete-all-posts-for-user/{userId};
* DELETE /post/delete-post-by-id/{postId};
* PATCH /post/update

#### DTOs:
* PostDto
    * Long userId;
    * Long photoId;
    * String postText;
    * LocalDateTime postDate;
==========

# COMMENTS SERVICE

#### Function:
* add a comment to the post;
    * check for a post to add a comment;
* get all the comments for the post;
* get the last five comments;
* delete a comment;
* delete all user comments;
* delete all comments for the post;


#### Endpoints:
* POST /comment (add a comment for this post);
* GET /comment/get-all-comment-for-post/{postId};
* GET /comment/get-five-last-comment-for-post/{postId};
* DELETE /comment/delete-all-user-comments/{userId};
* DELETE /comment/delete-all-comments-for-post/{postId};
* DELETE /comment/delete-comment/{commentId};

