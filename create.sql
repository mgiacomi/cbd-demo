create sequence bull_seq start with 1 increment by 50;
create sequence cow_seq start with 1 increment by 50;
create sequence herd_history_seq start with 1 increment by 50;
create sequence herd_seq start with 1 increment by 50;
create sequence milk_test_seq start with 1 increment by 50;
create sequence milking_seq start with 1 increment by 50;
create sequence vet_bill_seq start with 1 increment by 50;
create table bull (artificial_insemination boolean not null, id bigint not null, number varchar(10) unique, bull_id varchar(12) unique, primary key (id));
create table bull_calves (bull_id bigint not null, calves_id bigint not null unique);
create table cow (birth_date date not null, father_id bigint, herd_id bigint, id bigint not null, mother_id bigint, tag varchar(10) not null unique, status varchar(25) not null, primary key (id));
create table cow_calves (calves_id bigint not null unique, cow_id bigint not null);
create table cow_herd_history (cow_id bigint not null, herd_history_id bigint not null unique);
create table cow_milkings (cow_id bigint not null, milkings_id bigint not null unique);
create table cow_milk_tests (cow_id bigint not null, milk_tests_id bigint not null unique);
create table cow_vet_bills (cow_id bigint not null, vet_bills_id bigint not null unique);
create table herd (id bigint not null, name varchar(255) not null unique, primary key (id));
create table herd_cows (cows_id bigint not null unique, herd_id bigint not null);
create table herd_herd_histories (herd_histories_id bigint not null unique, herd_id bigint not null);
create table herd_history (start date not null, cow_id bigint, herd_id bigint, id bigint not null, primary key (id));
create table milking (gallons float4 not null, cow_id bigint, end timestamp(6), id bigint not null, start timestamp(6), primary key (id));
create table milk_test (butterfat float4 not null, date date, protien float4 not null, somatic_cell_count float4 not null, time float4 not null, weight float4 not null, cow_id bigint, id bigint not null, primary key (id));
create table vet_bill (amount_due numeric(38,2), date date, cow_id bigint, id bigint not null, comment varchar(255), procedures varchar(255), primary key (id));
alter table if exists bull_calves add constraint FK7p1vlhap9sjipuiv9oyspli9j foreign key (calves_id) references cow;
alter table if exists bull_calves add constraint FKgnpjbkdj9cx41jiinsmpyecin foreign key (bull_id) references bull;
alter table if exists cow add constraint FKnwetp2app300drqlj92dlrpcn foreign key (father_id) references bull;
alter table if exists cow add constraint FKkb4hn26pjecvs3gy75ukrhs65 foreign key (herd_id) references herd;
alter table if exists cow add constraint FKtepexf7bdc6v5pvyb1qkt781u foreign key (mother_id) references cow;
alter table if exists cow_calves add constraint FKfy5dyas240ein58dqtxrt0mv4 foreign key (calves_id) references cow;
alter table if exists cow_calves add constraint FK933s10iq4nipmo7apj2fsksxa foreign key (cow_id) references cow;
alter table if exists cow_herd_history add constraint FK8c6qvpy1q0dwvfc854oocid1u foreign key (herd_history_id) references herd_history;
alter table if exists cow_herd_history add constraint FKnnebjlikkiyh0xaod7429cex2 foreign key (cow_id) references cow;
alter table if exists cow_milkings add constraint FK8nefwj7yultd8b8xtxdp3qjem foreign key (milkings_id) references milking;
alter table if exists cow_milkings add constraint FKa150e1gyalbrbhlbspxkuwg75 foreign key (cow_id) references cow;
alter table if exists cow_milk_tests add constraint FKilq2gyas2q466sv4y6ocwj7l7 foreign key (milk_tests_id) references milk_test;
alter table if exists cow_milk_tests add constraint FK7rxgnrvxym317rx9in2an42et foreign key (cow_id) references cow;
alter table if exists cow_vet_bills add constraint FKg1i0y38pudd55jys4gjm3qf2y foreign key (vet_bills_id) references vet_bill;
alter table if exists cow_vet_bills add constraint FKnxn237sd29ck3wk6v793ddryd foreign key (cow_id) references cow;
alter table if exists herd_cows add constraint FKepos711b7nt4hawdw23ii6np1 foreign key (cows_id) references cow;
alter table if exists herd_cows add constraint FK7a5bn5ok084idktkha18hjv54 foreign key (herd_id) references herd;
alter table if exists herd_herd_histories add constraint FKbdsu2fpjnm7jgynhxjr65ujce foreign key (herd_histories_id) references herd_history;
alter table if exists herd_herd_histories add constraint FK2imvanos946jku2cogpn55ef4 foreign key (herd_id) references herd;
alter table if exists herd_history add constraint FKmn5egoa1r6l0a3i8k3ch4ypcc foreign key (cow_id) references cow;
alter table if exists herd_history add constraint FKru2lgyy9ayus5vxh0bhbia7pi foreign key (herd_id) references herd;
alter table if exists milking add constraint FKjhsqjtw7hdhlux889ttfxgocc foreign key (cow_id) references cow;
alter table if exists milk_test add constraint FKfldcf3tguexir51325g1ivhu9 foreign key (cow_id) references cow;
alter table if exists vet_bill add constraint FKhdib3lcemci6uvgpd34jkloy0 foreign key (cow_id) references cow;