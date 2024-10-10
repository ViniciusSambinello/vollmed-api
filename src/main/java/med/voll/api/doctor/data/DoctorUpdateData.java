package med.voll.api.doctor.data;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressData;

public record DoctorUpdateData(
        @NotNull Long id,
        String name,
        String phone,
        AddressData addressData
) {
}
