package com.turkcell.library_app_ddd_cqrs.core.cqrs;

public interface QueryHandler<Q extends Query<R>, R> {
	R handle(Q query);
}