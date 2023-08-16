export interface Profile {
  id: string;
  email: string;
  firstName: string;
  lastName: string;
  dateBirth: Date;
  phoneNumber: string;
  secret?: string;
}
