SELECT P.firstName, P.lastName, A.city, A.state
from person P LEFT JOIN Address A
on P.personId = A.personId;