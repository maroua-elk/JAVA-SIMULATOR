package Project;

import javax.persistence.*;

@Entity
@Table(name = "covid19", schema = "public")
public class hibernateEntity {
	@Id
	@Column(name = "datesdituation")
	private String datesdituation;
	@Basic
	@Column(name = "cas_semaine")
	private int cas_semaine;
	@Basic
	@Column(name = "deces_semaine")
	private int deces_semaine;
	@Basic
	@Column(name = "codepays")
	private String codepays;
	@Basic
	@Column(name = "ratio")
	private double ratio;

	public hibernateEntity(String datesdituation, int cas_semaine, int deces_semaine, String codepays, double d) {
		this.datesdituation = datesdituation;
		this.cas_semaine = cas_semaine;
		this.deces_semaine = deces_semaine;
		this.codepays = codepays;
		this.ratio = d;
	}

	public hibernateEntity() {

	}
}
