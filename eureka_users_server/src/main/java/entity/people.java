package entity;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
//@ToString
@Accessors(chain=true)
@NoArgsConstructor
public class people {

	private Integer Id;
	private BigDecimal IDcard;
	private String Name;
	private Integer Age;
	private char Sex;
	private Integer Money;
	private String Password;
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
