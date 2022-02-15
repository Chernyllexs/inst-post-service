# POST SERVICE
This service runs on port 9001 and is responsible for creating and views posts.

#### Function:

* add a post;
* send a photo to photo-service;
    * get all posts by user Id;
* get a post by postId;
    * delete all posts by user Id;
* delete a post by postId;
* checking the presence of the post;
* editing a post;
* photo editing;

#### Endpoints:
* POST /post/create (add a post);
* GET /post/get-all-posts-for-user/{userId};
* GET /post/get-post-by-id/{postId};
* GET /post/check-post/{postId};
* DELETE /post/delete-all-posts-for-user/{userId};
* DELETE /post/delete-post-by-id/{postId};
* ???PATCH /post/update

#### DTOs:
* PostDto:
    * Long postId;
    * Long userId;
    * Long photoId;
    * String postText;
    * LocalDateTime postDate;

* CreatedPostDto:
    * Long userId;
    * private String postText;
