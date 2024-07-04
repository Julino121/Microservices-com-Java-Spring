package com.ms.user.records;

public record UserRecordDto(@NotBlank String name,
                            @NotBlank @Email String email)
                            
{

}
