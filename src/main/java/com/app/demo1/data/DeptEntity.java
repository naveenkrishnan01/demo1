package com.app.demo1.data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "dept")
public class DeptEntity {

        @Id
        @GeneratedValue
        @Column(name="dept_id")
        private Integer deptId;
        @Column(name="dept_name")
        @NotBlank
        private String deptName;
        @NotBlank
        @Column(name ="dept_desc")
        private String deptDesc;
        @NotBlank
        @Column(name="Userid")
        private Integer UserId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="id", referencedColumnName = "id", nullable=true)
        private UserEntity userEntity;

        public DeptEntity(Integer deptId, String deptName, String deptDesc, Integer UserId) {
                this.deptId = deptId;
                this.deptName = deptName;
                this.deptDesc = deptDesc;
                this.UserId = UserId;
        }

        public DeptEntity() {

        }

        public Integer getDeptId() {
                return deptId;
        }

        public void setDeptId(Integer deptId) {
                this.deptId = deptId;
        }

        public String getDeptName() {
                return deptName;
        }

        public void setDeptName(String deptName) {
                this.deptName = deptName;
        }

        public String getDeptDesc() {
                return deptDesc;
        }

        public void setDeptDesc(String deptDesc) {
                this.deptDesc = deptDesc;
        }

        public Integer getUserId() {
                return UserId;
        }

        public void setUserId(Integer userId) {
                UserId = userId;
        }

        @Override
        public String toString() {
                return "DeptEntity{" +
                        "deptId=" + deptId +
                        ", deptName='" + deptName + '\'' +
                        ", deptDesc='" + deptDesc + '\'' +
                        ", UserId=" + UserId +
                        '}';
        }
}
