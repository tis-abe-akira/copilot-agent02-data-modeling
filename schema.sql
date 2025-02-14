-- リソースエンティティ
CREATE TABLE investor (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL
);

CREATE TABLE borrower (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    credit_rating VARCHAR(10) NOT NULL
);

CREATE TABLE bank (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    is_lead_bank BOOLEAN NOT NULL
);

CREATE TABLE facility (
    id BIGINT PRIMARY KEY,
    total_amount DECIMAL(19,4) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL
);

CREATE TABLE facility_participation (
    id BIGINT PRIMARY KEY,
    facility_id BIGINT NOT NULL,
    investor_id BIGINT NOT NULL,
    share_percentage DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (facility_id) REFERENCES facility(id),
    FOREIGN KEY (investor_id) REFERENCES investor(id)
);

CREATE TABLE drawdown_allocation (
    id BIGINT PRIMARY KEY,
    drawdown_id BIGINT NOT NULL,
    facility_participation_id BIGINT NOT NULL,
    amount DECIMAL(19,4) NOT NULL,
    FOREIGN KEY (facility_participation_id) REFERENCES facility_participation(id)
);

-- イベントエンティティ
CREATE TABLE syndicate_formation (
    id BIGINT PRIMARY KEY,
    facility_id BIGINT NOT NULL,
    formation_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (facility_id) REFERENCES facility(id)
);

CREATE TABLE drawdown (
    id BIGINT PRIMARY KEY,
    borrower_id BIGINT NOT NULL,
    total_amount DECIMAL(19,4) NOT NULL,
    drawdown_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (borrower_id) REFERENCES borrower(id)
);

CREATE TABLE interest_payment (
    id BIGINT PRIMARY KEY,
    drawdown_id BIGINT NOT NULL,
    amount DECIMAL(19,4) NOT NULL,
    payment_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (drawdown_id) REFERENCES drawdown(id)
);

CREATE TABLE principal_payment (
    id BIGINT PRIMARY KEY,
    drawdown_id BIGINT NOT NULL,
    amount DECIMAL(19,4) NOT NULL,
    payment_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (drawdown_id) REFERENCES drawdown(id)
);

CREATE TABLE fee_payment (
    id BIGINT PRIMARY KEY,
    facility_id BIGINT NOT NULL,
    amount DECIMAL(19,4) NOT NULL,
    payment_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (facility_id) REFERENCES facility(id)
);

CREATE TABLE facility_trade (
    id BIGINT PRIMARY KEY,
    facility_participation_id BIGINT NOT NULL,
    from_investor_id BIGINT NOT NULL,
    to_investor_id BIGINT NOT NULL,
    trade_date_time TIMESTAMP NOT NULL,
    FOREIGN KEY (facility_participation_id) REFERENCES facility_participation(id),
    FOREIGN KEY (from_investor_id) REFERENCES investor(id),
    FOREIGN KEY (to_investor_id) REFERENCES investor(id)
);

-- 情報変更イベントテーブル
CREATE TABLE investor_info_change (
    id BIGINT PRIMARY KEY,
    investor_id BIGINT NOT NULL,
    change_date_time TIMESTAMP NOT NULL,
    changes JSONB NOT NULL,
    FOREIGN KEY (investor_id) REFERENCES investor(id)
);

CREATE TABLE borrower_info_change (
    id BIGINT PRIMARY KEY,
    borrower_id BIGINT NOT NULL,
    change_date_time TIMESTAMP NOT NULL,
    changes JSONB NOT NULL,
    FOREIGN KEY (borrower_id) REFERENCES borrower(id)
);

CREATE TABLE bank_info_change (
    id BIGINT PRIMARY KEY,
    bank_id BIGINT NOT NULL,
    change_date_time TIMESTAMP NOT NULL,
    changes JSONB NOT NULL,
    FOREIGN KEY (bank_id) REFERENCES bank(id)
);