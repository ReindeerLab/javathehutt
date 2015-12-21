package hutt.core.dto.responses;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * APIのレスポンス情報を保持するクラス。
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class AbstractResponse {

  /** リクエストID */
  private String requestId;

  /** ステータスコード */
  private String statusCode;

  /** API結果 */
  private AbstractResult result;

  /** エラー一覧 */
  private List<Error> errors;

  @JsonInclude(Include.NON_NULL)
  public static abstract class AbstractResult {
  }

  /**
   * 1件のエラー情報を保持するクラス。
   */
  @Getter
  @Setter
  @JsonInclude(Include.NON_NULL)
  public static class Error {
    // 相関チェックの可能性を考慮してListにする
    private List<String> fields = new ArrayList<>();
    private String errorCode;
    private String message;
  }
}
