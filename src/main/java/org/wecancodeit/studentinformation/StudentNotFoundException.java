package org.wecancodeit.studentinformation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Bad Request! Student NOT FOUND!!!")
public class StudentNotFoundException extends Exception {

}
