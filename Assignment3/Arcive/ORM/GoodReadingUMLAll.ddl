ALTER TABLE BookReview modify column _approved tinyint(1);
ALTER TABLE SystemUser modify column _accountStatus tinyint(1);
ALTER TABLE Book modify column _summary varchar(255);
ALTER TABLE Book modify column _viewStatus tinyint(1);
ALTER TABLE Book modify column _searchLog varchar(255);
ALTER TABLE Book modify column _purchaseLog varchar(255);
ALTER TABLE Book ADD COLUMN _picPath varchar(255);
