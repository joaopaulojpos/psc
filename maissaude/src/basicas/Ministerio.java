package basicas;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Ministerio")
public class Ministerio extends Usuario{
	public Ministerio(){
		super();
	}
}
