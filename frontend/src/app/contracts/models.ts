export interface Comment {
  id: number;
  comment: string;
  user: User;
}

export interface Trail {
  id: number;
  user: User;
  trailName: string;
  trailDescription: string;
  suggestedGear: string;
  trailLength: number;
  hikeDuration: number;
  waterAvailability: boolean;
  path: string;
  comments: Comment[];
}

export interface User {
  id: number;
  firstName: string;
  lastName: string;
  userName: string;
  imagePath: string;
}
