package pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiEndpoints {
    TODOS("/todos"),
    POSTS("/posts"),
    COMMENTS("/comments"),
    ALBUMS("/albums"),
    PHOTOS("/photos"),
    USERS("/users");

    private final String uri;
}
