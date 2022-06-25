-- USERS TABLE
INSERT INTO
    users (
        user_Id,
        first_Name,
        last_Name,
        CIN,
        email,
        birthday,
        address,
        password,
        role,
        is_Active
    )
VALUES (
        NEXTVAL('user_sequence'),
        'othmane',
        'elkarmy',
        'bh111111',
        'othmane@gmail.com',
        current_timestamp,
        'casa',
        'password',
        'doctor',
        TRUE
    ), (
        NEXTVAL('user_sequence'),
        'Fati',
        'Errami',
        'bh222222',
        'Fati@gmail.com',
        current_timestamp,
        'casa',
        'password',
        'Patient',
        TRUE
    ), (
        NEXTVAL('user_sequence'),
        'Jinx',
        'Jinx',
        'bh333333',
        'Jinx@gmail.com',
        current_timestamp,
        'beltover',
        'password',
        'doctor',
        FALSE
    ), (
        NEXTVAL('user_sequence'),
        'Silco',
        'Silco',
        'bh444444',
        'Silco@gmail.com',
        current_timestamp,
        'casa',
        'password',
        'Patient',
        TRUE
    );

-- Supplier TABLE
INSERT INTO
    supplier (supplier_id, supplier_description, supplier_name)
VALUES (
        NEXTVAL('supplier_sequence'),
        'second supplier',
        'sup_2'
    ), (
        NEXTVAL('supplier_sequence'),
        'first supplier',
        'sup_1'
    );

INSERT INTO
    prescription (
        prescription_id,
        doctor_id,
        patient_id,
        prescription_date,
        prescription_description,
        prescription_status,
        prescription_name
    )
VALUES (
        NEXTVAL('prescription_sequence'),
        1,
        1,
        current_timestamp,
        'first prescription',
        'pending',
        'pres_1'
    ), (
        NEXTVAL('prescription_sequence'),
        1,
        2,
        current_timestamp,
        'second prescription',
        'pending',
        'pres_2'
    );

INSERT INTO
    orders (
        order_id,
        order_date,
        order_status,
        order_track_number,
        patient_id,
        total_price
    )
VALUES (
        NEXTVAL('order_sequence'),
        current_timestamp,
        'pending',
        '123456789',
        1,
        100
    ), (
        NEXTVAL('order_sequence'),
        current_timestamp,
        'pending',
        '123456789',
        2,
        200
    );

INSERT INTO
    drug (
        drug_id,
        drug_category_id,
        drug_created_at,
        drug_description,
        drug_name,
        drug_price,
        drug_quantity,
        drug_side_effects,
        drug_stock,
        drug_supplier_id,
        drug_usage,
        drug_warnings,
        need_prescription
    )
VALUES (
        NEXTVAL('drug_sequence'),
        1,
        current_timestamp,
        'first drug',
        'drug_1',
        100,
        10,
        'no side effects',
        10,
        1,
        'no usage',
        'no warnings',
        TRUE
    ), (
        NEXTVAL('drug_sequence'),
        1,
        current_timestamp,
        'second drug',
        'drug_2',
        200,
        20,
        'no side effects',
        20,
        1,
        'no usage',
        'no warnings',
        TRUE
    );

INSERT INTO
    composant (composant_id, composant_name)
VALUES (NEXTVAL('composant_sequence'), 'composant_1'), (NEXTVAL('composant_sequence'), 'composant_2');

INSERT INTO
    certification (
        certification_id,
        certification_date,
        certification_name,
        certification_number,
        doctor_id
    )
VALUES (
        NEXTVAL('certification_sequence'),
        current_timestamp,
        'certification_1',
        10,
        1
    ), (
        NEXTVAL('certification_sequence'),
        current_timestamp,
        'certification_2',
        20,
        2
    );

INSERT INTO
    category (category_id, category_description, category_name)
VALUES (
        NEXTVAL('category_sequence'),
        'category_1',
        'category_1'
    ), (
        NEXTVAL('category_sequence'),
        'category_2',
        'category_2'
    );