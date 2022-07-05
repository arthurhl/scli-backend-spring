package les.scli.utils;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeeklyPurchase {
    private Integer quantidade;
    private Date semana;
}
