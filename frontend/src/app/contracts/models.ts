export interface Trail {
  id: number;
  user: User;
  trailName: string;
  trailDescription: string;
  suggestedGear: string;
  trailLength: number;
  hikeDuration: number;
  waterAvailability: boolean;
}

export interface User {
  id: number;
  firstName: string;
  lastName: string;
  userName: string;
  password: string;
  imagePath: string;
  trails: Trail[];
}
