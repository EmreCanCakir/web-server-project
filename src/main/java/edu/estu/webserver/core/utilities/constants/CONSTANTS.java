package edu.estu.webserver.core.utilities.constants;

import edu.estu.webserver.core.utilities.results.Result;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class CONSTANTS {
    public ResponseEntity<?> getResponseEntity(Result result){
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
