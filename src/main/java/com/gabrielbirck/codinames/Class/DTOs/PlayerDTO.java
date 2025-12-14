package com.gabrielbirck.codinames.Class.DTOs;

import com.gabrielbirck.codinames.Class.Enum.GroupType;

public record PlayerDTO(

        String name,
        String email,
        String phoneNumber,
        GroupType groupType
) {
}
