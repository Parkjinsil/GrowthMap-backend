package com.growthMap.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBook is a Querydsl query type for Book
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBook extends EntityPathBase<Book> {

    private static final long serialVersionUID = 1975341805L;

    public static final QBook book = new QBook("book");

    public final NumberPath<Integer> menuCode = createNumber("menuCode", Integer.class);

    public final StringPath menuDesc = createString("menuDesc");

    public final StringPath menuName = createString("menuName");

    public final StringPath menuPicture = createString("menuPicture");

    public final StringPath menuPrice = createString("menuPrice");

    public QBook(String variable) {
        super(Book.class, forVariable(variable));
    }

    public QBook(Path<? extends Book> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBook(PathMetadata metadata) {
        super(Book.class, metadata);
    }

}

