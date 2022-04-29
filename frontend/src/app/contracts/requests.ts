export interface CreateTrailRequest {
  trailName: string;
  trailDescription: string;
  suggestedGear: string;
  trailLength: number;
  hikeDuration: number;
  waterAvailability: boolean;
}

export interface LogInRequest {
  userName: string;
  password: string;
}

export interface SignUpRequest {
  firstName: string;
  lastName: string;
  userName: string;
  password: string;
}
