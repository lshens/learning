export interface Address {
  id: string;
  postalCode: string;
  city: string;
  country: string;
  street: string;
  latitude?: number;
  longitude?: number;
}
