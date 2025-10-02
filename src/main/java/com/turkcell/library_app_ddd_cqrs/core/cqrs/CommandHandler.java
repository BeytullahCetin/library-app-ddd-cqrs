package com.turkcell.library_app_ddd_cqrs.core.cqrs;

public interface CommandHandler<C extends Command<R>, R> {
	R handle(C command);
}