package my.mycompany.myapp.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PriceIncreaseFormBean implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Max(1000)
	@Min(-100)
    private int percentage;

    public void setPercentage(int i) {
        percentage = i;
        log.debug("Percentage set to " + i);
    }

    public int getPercentage() {
        return percentage;
    }

}