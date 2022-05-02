package utils;

import rest.jsm.posts.Article;

import static utils.UserGeneratorUtils.makeStringRandom;

public class ArticleGeneratorUtils {

    public static final String TITLE = "newPostTitle";
    public static final String BODY = "newPostBody";
    public static final String DESCRIPTION = "newPostDescription";
    public static final String TAGS = "newPostTags";

    public static Article getRandomArticle() {
        return Article.builder()
                .title(makeStringRandom(TITLE))
                .body(makeStringRandom(BODY))
                .description(makeStringRandom(DESCRIPTION))
                .tagList(makeStringRandom(TAGS))
                .build();
    }
}
