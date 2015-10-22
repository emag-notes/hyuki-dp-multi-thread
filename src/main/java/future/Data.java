package future;

import java.util.concurrent.ExecutionException;

/**
 * @author Yoshimasa Tanabe
 */
public interface Data {
  String getContent() throws ExecutionException;
}
