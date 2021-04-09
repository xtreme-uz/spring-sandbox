package com.example.specification.service.impl;

import com.example.specification.criteria.filter.Filter;
import com.example.specification.criteria.filter.RangeFilter;
import com.example.specification.criteria.filter.StringFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

@Transactional(readOnly = true)
public abstract class QueryService<E> {

    protected <X> Specification<E> buildSpecification(Filter<X> filter, Function<Root<E>, Expression<X>> metaclassFunction) {
        if (filter.getEquals() != null) {
            return equalsSpecification(metaclassFunction, filter.getEquals());
        } else if (filter.getIn() != null) {
            return valueIn(metaclassFunction, filter.getIn());
        } else if (filter.getNotIn() != null) {
            return valueNotIn(metaclassFunction, filter.getNotIn());
        } else if (filter.getNotEquals() != null) {
            return notEqualsSpecification(metaclassFunction, filter.getNotEquals());
        } else if (filter.getSpecified() != null) {
            return byFieldSpecified(metaclassFunction, filter.getSpecified());
        }
        return null;
    }

    protected Specification<E> buildSpecification(StringFilter filter, Function<Root<E>, Expression<String>> metaclassFunction) {
        if (filter.getEquals() != null) {
            return equalsSpecification(metaclassFunction, filter.getEquals());
        } else if (filter.getIn() != null) {
            return valueIn(metaclassFunction, filter.getIn());
        } else if (filter.getNotIn() != null) {
            return valueNotIn(metaclassFunction, filter.getNotIn());
        } else if (filter.getContains() != null) {
            return likeUpperSpecification(metaclassFunction, filter.getContains());
        } else if (filter.getDoesNotContain() != null) {
            return doesNotContainSpecification(metaclassFunction, filter.getDoesNotContain());
        } else if (filter.getNotEquals() != null) {
            return notEqualsSpecification(metaclassFunction, filter.getNotEquals());
        } else if (filter.getSpecified() != null) {
            return byFieldSpecified(metaclassFunction, filter.getSpecified());
        }
        return null;
    }

    protected <X extends Comparable<? super X>> Specification<E> buildSpecification(RangeFilter<X> filter,
                                                                                         Function<Root<E>, Expression<X>> metaclassFunction) {
        if (filter.getEquals() != null) {
            return equalsSpecification(metaclassFunction, filter.getEquals());
        } else if (filter.getIn() != null) {
            return valueIn(metaclassFunction, filter.getIn());
        }

        Specification<E> result = Specification.where(null);
        if (filter.getSpecified() != null) {
            result = result.and(byFieldSpecified(metaclassFunction, filter.getSpecified()));
        }
        if (filter.getNotEquals() != null) {
            result = result.and(notEqualsSpecification(metaclassFunction, filter.getNotEquals()));
        }
        if (filter.getNotIn() != null) {
            result = result.and(valueNotIn(metaclassFunction, filter.getNotIn()));
        }
        if (filter.getGreaterThan() != null) {
            result = result.and(greaterThan(metaclassFunction, filter.getGreaterThan()));
        }
        if (filter.getGreaterThanOrEqual() != null) {
            result = result.and(greaterThanOrEqualTo(metaclassFunction, filter.getGreaterThanOrEqual()));
        }
        if (filter.getLessThan() != null) {
            result = result.and(lessThan(metaclassFunction, filter.getLessThan()));
        }
        if (filter.getLessThanOrEqual() != null) {
            result = result.and(lessThanOrEqualTo(metaclassFunction, filter.getLessThanOrEqual()));
        }
        return result;
    }

    protected <X> Specification<E> buildSpecification(Filter<X> filter, SingularAttribute<? super E, X> field) {
        return buildSpecification(filter, root -> root.get(field));
    }

    protected <X extends Comparable<? super X>> Specification<E> buildRangeSpecification(RangeFilter<X> filter, SingularAttribute<? super E, X> field) {
        return buildSpecification(filter, root -> root.get(field));
    }

    protected Specification<E> buildStringSpecification(StringFilter filter, SingularAttribute<? super E, String> field) {
        return buildSpecification(filter, root -> root.get(field));
    }

    protected Specification<E> likeUpperSpecification(Function<Root<E>, Expression<String>> metaclassFunction,
                                                      final String value) {
        return (root, query, builder) -> builder.like(builder.upper(metaclassFunction.apply(root)), wrapLikeQuery(value));
    }

    protected Specification<E> doesNotContainSpecification(Function<Root<E>, Expression<String>> metaclassFunction,
                                                           final String value) {
        return (root, query, builder) -> builder.not(builder.like(builder.upper(metaclassFunction.apply(root)), wrapLikeQuery(value)));
    }

    protected <X> Specification<E> byFieldSpecified(Function<Root<E>, Expression<X>> metaclassFunction,
                                                    final boolean specified) {
        return specified ?
                (root, query, builder) -> builder.isNotNull(metaclassFunction.apply(root)) :
                (root, query, builder) -> builder.isNull(metaclassFunction.apply(root));
    }

    protected <X> Specification<E> byFieldEmptiness(Function<Root<E>, Expression<Set<X>>> metaclassFunction,
                                                    final boolean specified) {
        return specified ?
                (root, query, builder) -> builder.isNotEmpty(metaclassFunction.apply(root)) :
                (root, query, builder) -> builder.isEmpty(metaclassFunction.apply(root));
    }

    protected <X> Specification<E> equalsSpecification(Function<Root<E>, Expression<X>> metaclassFunction, final X value) {
        return (root, query, builder) -> builder.equal(metaclassFunction.apply(root), value);
    }

    protected <X> Specification<E> notEqualsSpecification(Function<Root<E>, Expression<X>> metaclassFunction, final X value) {
        return (root, query, builder) -> builder.not(builder.equal(metaclassFunction.apply(root), value));
    }

    protected <X extends Comparable<? super X>> Specification<E> greaterThanOrEqualTo(Function<Root<E>, Expression<X>> metaclassFunction,
                                                                                      final X value) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(metaclassFunction.apply(root), value);
    }

    protected <X extends Comparable<? super X>> Specification<E> lessThanOrEqualTo(Function<Root<E>, Expression<X>> metaclassFunction,
                                                                                   final X value) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(metaclassFunction.apply(root), value);
    }

    protected <X extends Comparable<? super X>> Specification<E> lessThan(Function<Root<E>, Expression<X>> metaclassFunction,
                                                                          final X value) {
        return (root, query, builder) -> builder.lessThan(metaclassFunction.apply(root), value);
    }

    protected <X extends Comparable<? super X>> Specification<E> greaterThan(Function<Root<E>, Expression<X>> metaclassFunction,
                                                                             final X value) {
        return (root, query, builder) -> builder.greaterThan(metaclassFunction.apply(root), value);
    }


    protected <X> Specification<E> valueIn(Function<Root<E>, Expression<X>> metaclassFunction,
                                           final Collection<X> values) {
        return (root, query, builder) -> {
            In<X> in = builder.in(metaclassFunction.apply(root));
            for (X value : values) {
                in = in.value(value);
            }
            return in;
        };
    }

    protected <X> Specification<E> valueNotIn(Function<Root<E>, Expression<X>> metaclassFunction,
                                              final Collection<X> values) {
        return (root, query, builder) -> {
            In<X> in = builder.in(metaclassFunction.apply(root));
            for (X value : values) {
                in = in.value(value);
            }
            return builder.not(in);
        };
    }

    protected String wrapLikeQuery(String txt) {
        return "%" + txt.toUpperCase() + '%';
    }

}
