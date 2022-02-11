# SCORES SERVICE

#### Function:
* Rate the post (like/dislike);
    * Check the availability of a rating post;
    * Check if the user has previously given a different rating;
* Delete a user's rating for a post;
* Delete all user ratings;
* Delete all ratings for the post;
* Det the number of likes/dislikes;

#### Endpoints:
* GET /score/get-number-score-for-post/{postId} (the number of scores of a post by postId);
* POST /score (put a rating for this post);
* DELETE /score/delete-user-score-for-post/{postId, userId}
* DELETE /score/delete-all-user-scores/{userId}
* DELETE /score/delete-all-scores-for-post/{postId}

#### DTOs:
* ScoreDto
    * Long postId;
    * Long userId;
    * Boolean scoreState;
* ScoreResponseDto
    * Long numberOfLikes;
    * Long numberOfDislikes;