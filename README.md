# Post service
This service runs on port 9010 and is responsible for creating posts.

#### Endpoints:
* @PostMapping("/add") - add new post;
* @DeleteMapping("/{id}") - delete post;
* @GetMapping - get all posts (for test);
* @GetMapping("/{id}") - get post (for test);
* @GetMapping("/userId/{id}") - get posts for this user sorted by creation date;