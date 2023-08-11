package com.arcone.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.arcone.learning.util.IdUtil.uuid;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.TemporalType.TIME;
import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "task_logs")
public class TaskLogPO {

    @Id
    @Builder.Default
    private String id = uuid();
    @Temporal(TIMESTAMP)
    private LocalDateTime changeDateTime;
    @Temporal(DATE)
    private LocalDate inputDate;
    @Temporal(TIME)
    private LocalTime inputTime;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserPO user;
    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private TaskCategoryPO category;

}
