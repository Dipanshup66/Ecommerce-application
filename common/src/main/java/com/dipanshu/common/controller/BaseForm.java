package com.dipanshu.common.controller;

public class BaseForm {

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BaseEntity getDto() {
		return null;
	}

	public <T extends BaseEntity> T initEntity(T dto) {
		if (id != null && id > 0) {
			dto.setId(id);

		} else {
			dto.setId(null);
		}
		return dto;
	}

}
