package com.Sepotipi.tugas14.Jpa;

import com.Sepotipi.tugas14.entity.Song;
import com.Sepotipi.tugas14.entity.Transaction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;

public class TransactionJpaSpescification {


        public static Specification<Transaction> findByTitle(Transaction transaction){
            return new Specification<Transaction>() {
                @Override
                public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    final Collection<Predicate> predicates = new ArrayList<>();
                    Join<Transaction, Song> join = root.join("item", JoinType.INNER);
                    if (transaction != null){
                        if (!StringUtils.isEmpty(transaction.getTitle())){
                            final Predicate titlePredicate = criteriaBuilder.like(criteriaBuilder.lower(join.get("title")), "%"+transaction.getTitle()+"%");
                            predicates.add(titlePredicate);
                        }
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                }
            };
        }


    public static Specification<Transaction> findByGreathetThanAmount(Transaction transaction){
       return new Specification<Transaction>() {
           @Override
           public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
               final Collection<Predicate> predicates = new ArrayList<>();
               if (transaction != null){
                   if (!StringUtils.isEmpty(transaction.getAmount())){
                       final Predicate amountPredicate = criteriaBuilder.lessThan(root.get("amount"), transaction.getAmount());
                       predicates.add(amountPredicate);
                   }
               }
               return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
           }
       };
    }

    public static Specification<Transaction> findByLessThanAmount(Transaction transaction){
        return new Specification<Transaction>() {
            @Override
            public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                final Collection<Predicate> predicates = new ArrayList<>();
                if (transaction != null) {
                    if (!StringUtils.isEmpty(transaction.getAmount())) {
                        final Predicate amountGreaterThanPredicate = criteriaBuilder.greaterThan(root.get("amount"), transaction.getAmount());
                        predicates.add(amountGreaterThanPredicate);
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
