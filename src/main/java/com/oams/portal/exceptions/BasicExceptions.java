package com.oams.portal.exceptions;

import java.io.Serial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class BasicExceptions extends RuntimeException{

    @Serial
    private static final long SerialUID = 1;
    private String message;
    
}
