package com.famaridon.rp.server.domain.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by famaridon on 23/05/2016.
 */
@Entity
public class Version extends AbstractEntity {
	@Column(nullable = false)
	private Long major;
	@Column(nullable = false)
	private Long minor = 0L;
	@Column(nullable = false)
	private Long incrementalVersion = 0L;
	private String build;
	private Qualifier qualifier;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	private SetupBinaryFile setupBinaryFile;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<FixBinaryFile> fixes = new HashSet<>();
	
	/**
	 * get {@link Version#major} property
	 *
	 * @return get the major property
	 **/
	public Long getMajor() {
		return major;
	}
	
	/**
	 * set {@link Version#major} property
	 *
	 * @param major set the major property
	 **/
	public void setMajor(Long major) {
		this.major = major;
	}
	
	/**
	 * get {@link Version#minor} property
	 *
	 * @return get the minor property
	 **/
	public Long getMinor() {
		return minor;
	}
	
	/**
	 * set {@link Version#minor} property
	 *
	 * @param minor set the minor property
	 **/
	public void setMinor(Long minor) {
		this.minor = minor;
	}
	
	/**
	 * get {@link Version#incrementalVersion} property
	 *
	 * @return get the incrementalVersion property
	 **/
	public Long getIncrementalVersion() {
		return incrementalVersion;
	}
	
	/**
	 * set {@link Version#incrementalVersion} property
	 *
	 * @param incrementalVersion set the incrementalVersion property
	 **/
	public void setIncrementalVersion(Long incrementalVersion) {
		this.incrementalVersion = incrementalVersion;
	}
	
	/**
	 * get {@link Version#build} property
	 *
	 * @return get the build property
	 **/
	public String getBuild() {
		return build;
	}
	
	/**
	 * set {@link Version#build} property
	 *
	 * @param build set the build property
	 **/
	public void setBuild(String build) {
		this.build = build;
	}
	
	/**
	 * get {@link Version#qualifier} property
	 *
	 * @return get the qualifier property
	 **/
	public Qualifier getQualifier() {
		return qualifier;
	}
	
	/**
	 * set {@link Version#qualifier} property
	 *
	 * @param qualifier set the qualifier property
	 **/
	public void setQualifier(Qualifier qualifier) {
		this.qualifier = qualifier;
	}
	
	/**
	 * get {@link Version#setupBinaryFile} property
	 *
	 * @return get the setupBinaryFile property
	 **/
	public SetupBinaryFile getSetupBinaryFile() {
		return setupBinaryFile;
	}
	
	/**
	 * set {@link Version#setupBinaryFile} property
	 *
	 * @param setupBinaryFile set the setupBinaryFile property
	 **/
	public void setSetupBinaryFile(SetupBinaryFile setupBinaryFile) {
		this.setupBinaryFile = setupBinaryFile;
	}
	
	/**
	 * get {@link Version#fixes} property
	 *
	 * @return get the fixes property
	 **/
	public Set<FixBinaryFile> getFixes() {
		return fixes;
	}
	
	/**
	 * set {@link Version#fixes} property
	 *
	 * @param fixes set the fixes property
	 **/
	public void setFixes(Set<FixBinaryFile> fixes) {
		this.fixes = fixes;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("major", major).append("id", id).append("minor", minor).append("incrementalVersion", incrementalVersion).append("build", build).append("qualifier", qualifier).toString();
	}
}
